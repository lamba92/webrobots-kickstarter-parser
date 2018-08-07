package parser

import data.ThinProject
import main.changeChars
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

class FileParser(private val input: Collection<File>, private val output: File){

    private val projectsQueue = LinkedBlockingQueue<ThinProject>()

    fun start(){
        val a = Thread{ input.forEach { parse(it) } }.apply { start() }
        val b = Thread{ writeOut() }.apply { start() }
        a.join()
        b.join()
    }

    private fun writeOut(){
        output.printWriter().use {
            while(true){
                val p = projectsQueue.poll(1, TimeUnit.SECONDS) ?: break
                it.println(p.toCSV())
            }
        }
    }

    private fun parse(file: File){
        file.forEachLine {
            try {
                val doc = JSONObject(it)
                val data = doc.getJSONObject("data")
                val id = data.getLong("id")
                val goal = data.getInt("goal")
                val name = data.getString("name")
                val country = data.getString("country")
                val creatorName = data.getJSONObject("creator").getString("name")
                val pledged = data.getFloat("pledged")
                val state = data.getJSONObject("profile").getString("state")
                val categorySlug = data.getJSONObject("category").getString("slug")
                val categoryName = data.getJSONObject("category").getString("name")
//            val location = data.getJSONObject("location").getString("country")
                val s = doc.getString("created_at").changeChars()
                val databaseCreatedAt = LocalDate
                        .parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd-kk:mm:ss"))
                        .atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
                val region = try{
                    data.getJSONObject("location").getString("state")
                } catch (e: JSONException){
                    e.printStackTrace()
                    ""
                }
                val creationDate = data.getLong("created_at")
                val launchedDate = data.getLong("launched_at")
                val deadline = data.getLong("deadline")
                val stateChangedAt = data.getLong("state_changed_at")
                val backersCount = data.getInt("backers_count")

                projectsQueue.add(
                        ThinProject(
                                id, name, goal, categoryName, categorySlug, country, region,
                                state, pledged, deadline, creationDate, launchedDate,
                                stateChangedAt, backersCount, creatorName, databaseCreatedAt
                        )
                )
            } catch (e: JSONException){
                e.printStackTrace()
            }
        }
    }
}