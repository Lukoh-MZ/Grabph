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

package com.goforer.grabph.repository.interactor.paging.datasource

import androidx.paging.PageKeyedDataSource
import com.goforer.grabph.repository.model.cache.data.entity.home.Home

class PopSearperListDataSource(private val list: List<Home.PopSearper.Searper>)
                                            : PageKeyedDataSource<Int, Home.PopSearper.Searper>() {
    override fun loadInitial(params: LoadInitialParams<Int>,
                             callback: LoadInitialCallback<Int, Home.PopSearper.Searper>) {
        callback.onResult(list as MutableList<Home.PopSearper.Searper>, null, null)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Home.PopSearper.Searper>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Home.PopSearper.Searper>) {
    }
}