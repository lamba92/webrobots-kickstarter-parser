package data

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

data class ThinProject(
        var id: Long,
        var name: String,
        var goal: Int,
        var category_name: String,
        var category_slug: String,
        var country: String,
        var region: String,
        var state: String,
        var pledged: Float,
        var deadline: Long,
        var created_at: Long,
        var launched_at: Long,
        var state_changed_at: Long,
        var backers_count: Int,
        var creator_name: String,
        var database_created_at: Long
) {
    fun toCSV() = "$id;-;" +
            "$name;-;" +
            "$goal;-;" +
            "$category_name;-;" +
            "$category_slug;-;" +
            "$country;-;" +
            "$region;-;" +
            "$state;-;" +
            "$pledged;-;" +
            "$deadline;-;" +
            "$created_at;-;" +
            "$launched_at;-;" +
            "$state_changed_at;-;" +
            "$backers_count;-;" +
            "$creator_name;-;" +
            "$database_created_at"

//    fun toCSV2(){
//        var s = ""
//        this::class.declaredMemberProperties.forEach {
//            s += it.toString() + ";-;"
//        }
//        s.removeRange(s.length-2, s.length-1)
//    }
}