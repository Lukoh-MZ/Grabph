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

package com.goforer.grabph.repository.model.cache.data.mock.datasource.qeust

import com.goforer.grabph.repository.model.cache.data.mock.entity.TopPortionQuestIn
import com.goforer.grabph.repository.model.cache.data.entity.quest.TopPortionQuest
import com.google.gson.GsonBuilder

class TopPortionQuestDataSource {
    private var topPortionQuestIn: TopPortionQuestIn? = null

    internal fun setTopPortionQuest() {
        val topPortionQuest = "{\"topPortionQuest\":{\"itemcount\":2,\"hotQuest\":{\"title\":\"Hot Quest\",\"quests\":[{\"idx\":3,\"id\":\"N34343_3@N01\",\"owner\":\"3@N01\",\"ownerName\":\"Ford\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/ford_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/ford_travel.jpg\",\"favoriteCategory\":\"Car\",\"title\":\"Great travel season.\",\"state\":\"On a quest\",\"description\":\"Show us great travel photo that is taken by you in this winter. Great snow-fall scenery with Ford SUV! Decided to travel with family and Ford SUV in this winter? Even better. Want to spend more time with your family in this winter?\",\"rewards\":\"1,500\",\"duration\":14},\n" +
                    "{\"idx\":4,\"id\":\"P34342_4@N01\",\"owner\":\"4@N01\",\"ownerName\":\"Nikon\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/nikon_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/nikon_travel.jpg\",\"favoriteCategory\":\"Travel\",\"title\":\"Beautiful spring  scenery!\",\"state\":\"On a quest\",\"description\":\"Take your beautiful photo that is taken by you in this spring.  Great forest scenery! Decided to travel with family in this spring? Even better. Want to spend more time with your family in this spring?\",\"rewards\":\"2,500\",\"duration\":7},\n" +
                    "{\"idx\":6,\"id\":\"F14342_6@N01\",\"owner\":\"6@N01\",\"ownerName\":\"Cannon\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/cannon_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/cannon_travel.jpg\",\"favoriteCategory\":\"Travel\",\"title\":\"Beautiful beach scenery!\",\"state\":\"On a quest\",\"description\":\"Show us your beautiful photo that is taken by you in beautiful beach. Great cool scenery! Decided to travel with family in this summer? Even better. Want to spend more time with your family in this summer?\",\"rewards\":\"2,500\",\"duration\":24},\n" +
                    "{\"idx\":7,\"id\":\"E62342_7@N01\",\"owner\":\"7@N01\",\"ownerName\":\"BMW\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/bmw_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/bmw_travel.jpg\",\"favoriteCategory\":\"Travel\",\"title\":\"Drive on the road\",\"state\":\"On a missionItem\",\"description\":\"Show us BMW SUV photo that is taken by you in this winter. Great snow-fall scenery! Decided to travel with family in this winter? Even better. Want to spend more time with your family in this winter?\",\"rewards\":\"4,000\",\"duration\":9}," +
                    "{\"idx\":8,\"id\":\"G94342_8@N01\",\"owner\":\"8@N01\",\"ownerName\":\"TripAdvisor\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/tripadvisor_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/tripadvisor_travel.jpg\",\"favoriteCategory\":\"Travel\",\"title\":\"Awesome winter season\",\"state\":\"On a quest\",\"description\":\"Show us your snow-fall photo that is taken by you in this winter. Great snow-fall scenery! Decided to travel with your honey in this winter? Even better. Want to spend more time with your honey in this winter?\",\"rewards\":\"2,000\",\"duration\":15},\n" +
                    "{\"idx\":9,\"id\":\"P34342_9@N01\",\"owner\":\"9@N01\",\"ownerName\":\"GoEuro\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/goeuro_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/goeuro_travel.jpg\",\"favoriteCategory\":\"Travel\",\"title\":\"Europe in spring season\",\"state\":\"On a quest\",\"description\":\"Show us your beautiful photo that is taken by you in Europe. Great beautiful Europe scenery! Decided to travel with family in this winter? Even better. Want to spend more time with your family in Europe?\",\"rewards\":\"2,500\",\"duration\":10},\n" +
                    "{\"idx\":10,\"id\":\"S34342_10@N01\",\"owner\":\"10@N01\",\"ownerName\":\"Mercedes - Benz\",\"ownerLogo\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/Logo/benz_logo.png\",\"ownerImage\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/MainImage/benz_travel.jpg\",\"favoriteCategory\":\"car\",\"title\":\"Drive on the way\",\"state\":\"On a quest\",\"description\":\"Show us your SUV photo that is taken by you in this winter. Great snow-fall scenery! Decided to travel with family in this winter? Even better. Want to spend more time with your family in this winter?\",\"rewards\":\"4,500\",\"duration\":6}]},\n" +
                    "\"favoriteKeyword\":{\"title\":\"Favorite Keyword\",\"keywords\":[{\"id\":1,\"title\":\"All\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":2,\"title\":\"Art\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":4,\"title\":\"Car\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":7,\"title\":\"Education\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":15,\"title\":\"Fashion\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":17,\"title\":\"Food\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":19,\"title\":\"Sport\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"},{\"id\":25,\"title\":\"Travel\",\"image\":\"https://raw.githubusercontent.com/Lukoh/Grabph_Mission/master/Provider/favorite_keyword/favorite_keyword.jpeg\"}]}}}"

        topPortionQuestIn = GsonBuilder().serializeNulls().create().fromJson(topPortionQuest, TopPortionQuestIn::class.java)
    }

    internal fun getTopPortionQuest(): TopPortionQuest? {
        this.topPortionQuestIn?.topPortionQuest?.let {
            return this.topPortionQuestIn?.topPortionQuest
        }

        throw IllegalArgumentException("QuestInfo have to be not null")
    }
}