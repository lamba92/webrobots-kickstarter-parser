package parser

import data.Project
import data.ThinProject
import org.json.JSONObject
import java.io.File
import java.util.concurrent.LinkedBlockingQueue

class FileParser(worker: (Project)){

    val projectsQueue = LinkedBlockingQueue<ThinProject>()

    fun parse(file: File){
        file.forEachLine {
            val data = JSONObject(it).getJSONObject("data")
            val id = data.getString("id")
            val goal = data.getInt("goal")
            val name = data.getString("name")
            val country = data.getString("country")
            val creatorName = data.getJSONObject("creator").getString("name")
            val pledged = data.getFloat("pledged")
            val state = data.getJSONObject("profile").getString("state")
            val categorySlug = data.getJSONObject("category").getString("slug")
            val categoryName = data.getJSONObject("category").getString("name")
//            val location = data.getJSONObject("location").getString("country")
            val region = data.getJSONObject("location").getString("state")
            val creationDate = data.getLong("created_at")
            val launchedDate = data.getLong("launched_date")
            val deadline = data.getLong("deadline")
            val stateChangedAt = data.getLong("state_changed_at")
            val backersCount = data.getInt("backers_count")

            projectsQueue.add(
                    ThinProject(
                            id, name, goal, categoryName, categorySlug, country, region,
                            state, pledged, deadline, creationDate, launchedDate,
                            stateChangedAt, backersCount, creatorName
                    )
            )
        }
    }
}