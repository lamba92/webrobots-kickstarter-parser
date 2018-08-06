package data

data class ThinProject(
        var id: String,
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
        var creator_name: String
)