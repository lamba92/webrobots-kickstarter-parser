package data

data class Project(
        var id: String,
        var robot_id: String,
        var run_id: String,
        var created_at: String,
        var table_id: String,
        var data: Data){
    data class Data(
            var id: String,
            var goal: Float,
            var name: String,
            var slug: String,
            var urls: DataUrls,
            var blurb: String,
            var photo: Photo,
            var state: String,
            var country: String,
            var creator: Creator,
            var fx_rate: Int,
            var pledged: Int,
            var profile: Profile,
            var category: Category,
            var currency: String,
            var deadline: Long,
            var location: Location,
            var usd_type: String,
            var spotlight: Boolean,
            var created_at: Long,
            var source_url: String,
            var staff_pick: Boolean,
            var launched_at: Long,
            var usd_pledged: Float,
            var is_starrable: Boolean,
            var backers_count: Int,
            var currency_symbol: String,
            var static_usd_rate: Float,
            var current_currency: String,
            var state_changed_at: Long,
            var disabled_communication: Boolean,
            var currency_trailng_code: Boolean,
            var converted_pledged_amount: Int){
        data class DataUrls(var web: Web){
            data class Web(
                    var project: String,
                    var rewards: String)
        }
        data class Photo(
                var head: String,
                var key: String,
                var med: String,
                var full: String,
                var small: String,
                var thumb: String,
                var little: String //MANCANO 2 ELEMENTI CHE INIZIANO CON UN NUMERO
        )
        data class Creator(
                var id: String,
                var name: String,
                var slug: String,
                var urls: CreatorUrls,
                var avatar: Avatar,
                var is_registered: Boolean,
                var chosen_currency: String?
        ){
            data class CreatorUrls(var api: Api, var web: Api){
                data class Api(var user: String)
            }
            data class Avatar(var small: String, var thumb: String, var medium: String)
        }
        data class Profile(
                var id: String,
                var name: String?,
                var blurb: String?,
                var state: String?,
                var link_url: String?,
                var link_text: String?,
                var project_id: String?,
                var text_color: String?,
                var link_text_color: String?,
                var background_color: String?,
                var state_changed_at: String?,
                var show_feature_image: Boolean?,
                var link_background_color: String?,
                var background_image_opacity: Float?,
                var feature_image_attributes: FeatureImageAttributes,
                var should_show_features_image_section: Boolean?
        ){
            data class FeatureImageAttributes(var image_urls: ImageUrls){
                data class ImageUrls(var default: String?, var baseball_card: String?)
            }
        }
        data class Category(
                var id: String,
                var name: String,
                var slug: String,
                var urls: CategoryUrls,
                var color: Int,
                var position: Int,
                var parent_id: Int
        ){
            data class CategoryUrls(var web: CategoryUrlsWeb){
                data class CategoryUrlsWeb(var discover: String?)
            }
        }
        data class Location(
                var id: String,
                var name: String,
                var slug: String,
                var type: String,
                var urls: LocationUrls,
                var state: String,
                var country: String,
                var is_root: Boolean,
                var short_name: String,
                var localized_name: String,
                var displayable_name: String
        ){
            data class LocationUrls(var api: LocationUrlsApi, var web: LocationUrlsWeb){
                data class LocationUrlsApi(var nearby_projects: String)
                data class LocationUrlsWeb(var discover: String, var location: String)
            }
        }
    }
}