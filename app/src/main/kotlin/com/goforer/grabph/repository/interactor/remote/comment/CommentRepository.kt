/*
 * Copyright 2019 Lukoh Nam, goForer
 *    
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, 
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details. 
 * You should have received a copy of the GNU General Public License along with this program.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.goforer.grabph.repository.interactor.remote.comment

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.goforer.grabph.presentation.vm.BaseViewModel
import com.goforer.grabph.repository.interactor.remote.Repository
import com.goforer.grabph.repository.model.cache.data.entity.comments.Comment
import com.goforer.grabph.repository.model.cache.data.entity.comments.PhotoComments
import com.goforer.grabph.repository.model.dao.remote.comment.CommentDao
import com.goforer.grabph.repository.network.response.Resource
import com.goforer.grabph.repository.network.resource.NetworkBoundResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepository
@Inject
constructor(private val dao: CommentDao): Repository() {
    companion object {
        const val METHOD = "flickr.photos.comments.getList"
    }

    override suspend fun load(viewModel: BaseViewModel, query1: String, query2: Int, loadType: Int,
                              boundType: Int, calledFrom: Int): LiveData<Resource> {
        return object: NetworkBoundResource<MutableList<Comment>, PagedList<Comment>,
                                                            PhotoComments>(loadType, boundType) {
            override suspend fun saveToCache(item: MutableList<Comment>) =  dao.insert(item)

            // This function had been blocked at this time but it might be used in the future
            /*
            override fun shouldFetch(): Boolean {
                return true
            }
            */

            override suspend fun loadFromCache(isLatest: Boolean, itemCount: Int,
                                               pages: Int): LiveData<PagedList<Comment>> {
                val config = PagedList.Config.Builder()
                        .setInitialLoadSizeHint(20)
                        .setPageSize(10)
                        .setPrefetchDistance(5)
                        .setEnablePlaceholders(true)
                        .build()

                return LivePagedListBuilder<Int, Comment>(dao.getComments(),
                        /* PageList Config */ config).build()
            }

            override suspend fun loadFromNetwork() = searpService.getComments(KEY, query1, METHOD, FORMAT_JSON, INDEX)

            override fun onNetworkError(errorMessage: String?, errorCode: Int) {
            }

            override fun onFetchFailed(failedMessage: String?) = repoRateLimit.reset(query1)

            override suspend fun clearCache() = dao.clearAll()
        }.getAsLiveData()
    }

    internal fun loadComments() = LivePagedListBuilder(dao.getComments(),
            /* page size */
            PagedList.Config.Builder().setPageSize(PER_PAGE).build()).build()

    internal fun removeComments() = dao.clearAll()
}