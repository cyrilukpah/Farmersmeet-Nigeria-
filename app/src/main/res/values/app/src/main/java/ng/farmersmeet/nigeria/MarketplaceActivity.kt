package ng.farmersmeet.nigeria

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MarketplaceActivity : AppCompatActivity() {

    private val green = Color.rgb(23, 107, 58)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showMarketplace()
    }

    private fun showMarketplace() {

        val root = LinearLayout(this)

        root.orientation =
            LinearLayout.VERTICAL

        root.setPadding(
            20,
            20,
            20,
            20
        )

        root.setBackgroundColor(
            Color.rgb(244, 248, 245)
        )

        // Header
        val header = TextView(this)

        header.text =
            "🌱 FarmersMeet Nigeria"

        header.textSize = 25f

        header.setTextColor(green)

        header.gravity =
            Gravity.CENTER

        root.addView(header)

        val subtitle = TextView(this)

        subtitle.text =
            "Where Farmers Meet Buyers"

        subtitle.gravity =
            Gravity.CENTER

        root.addView(subtitle)

        // Search
        val search =
            EditText(this)

        search.hint =
            "Search livestock, feeds, equipment..."

        root.addView(search)

        val searchButton =
            Button(this)

        searchButton.text =
            "🔎 Search"

        searchButton.setOnClickListener {

            Toast.makeText(
                this,
                "Searching for: ${search.text}",
                Toast.LENGTH_SHORT
            ).show()
        }

        root.addView(searchButton)

        // Categories
        val categoryTitle =
            TextView(this)

        categoryTitle.text =
            "Categories"

        categoryTitle.textSize =
            21f

        categoryTitle.setTextColor(
            Color.DKGRAY
        )

        root.addView(categoryTitle)

        val categories =
            arrayOf(
                "🐄 Livestock",
                "🐖 Pigs & Piglets",
                "🐔 Poultry",
                "🐐 Goats & Sheep",
                "🌾 Feeds",
                "🚜 Farm Equipment",
                "🩺 Veterinary Services",
                "🏠 Farmland",
                "🛠 Farm Services"
            )

        val categoryScroll =
            HorizontalScrollView(this)

        val categoryBox =
            LinearLayout(this)

        categoryBox.orientation =
            LinearLayout.HORIZONTAL

        categories.forEach { category ->

            val button =
                Button(this)

            button.text =
                category

            button.setOnClickListener {

                Toast.makeText(
                    this,
                    "$category selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            categoryBox.addView(
                button
            )
        }

        categoryScroll.addView(
            categoryBox
        )

        root.addView(
            categoryScroll,
            LinearLayout.LayoutParams(
                -1,
                70
            )
        )

        // Main buttons
        val favorites =
            Button(this)

        favorites.text =
            "❤️ My Favorites"

        favorites.setOnClickListener {

            Toast.makeText(
                this,
                "Favorites will be connected next.",
                Toast.LENGTH_SHORT
            ).show()
        }

        root.addView(favorites)

        val sellerDashboard =
            Button(this)

        sellerDashboard.text =
            "👨🏾‍🌾 Seller Dashboard"

        sellerDashboard.setOnClickListener {

            Toast.makeText(
                this,
                "Seller Dashboard coming next.",
                Toast.LENGTH_SHORT
            ).show()
        }

        root.addView(
            sellerDashboard
        )

        val postListing =
            Button(this)

        postListing.text =
            "➕ Post a Listing"

        postListing.setOnClickListener {

            showPostListing()
        }

        root.addView(
            postListing
        )

        // Featured listings
        val featuredTitle =
            TextView(this)

        featuredTitle.text =
            "⭐ Featured Listings"

        featuredTitle.textSize =
            21f

        featuredTitle.setTextColor(
            Color.DKGRAY
        )

        root.addView(
            featuredTitle
        )

        val listingScroll =
            ScrollView(this)

        val listings =
            LinearLayout(this)

        listings.orientation =
            LinearLayout.VERTICAL

        addListing(
            listings,
            "🐖 Large White Pig — 85kg",
            "₦250,000",
            "Abakaliki, Ebonyi",
            "Chukwu Farm"
        )

        addListing(
            listings,
            "🐷 Healthy Piglets — 8 Weeks",
            "₦55,000 each",
            "Enugu",
            "Green Valley Farm"
        )

        addListing(
            listings,
            "🌾 Premium Pig Feed",
            "₦38,000 / bag",
            "Aba, Abia",
            "AgroFeed Depot"
        )

        addListing(
            listings,
            "🚜 Used Feed Mixer",
            "₦450,000",
            "Onitsha",
            "Agro Machines"
        )

        listingScroll.addView(
            listings
        )

        root.addView(
            listingScroll,
            LinearLayout.LayoutParams(
                -1,
                0,
                1f
            )
        )

        setContentView(root)
    }

    private fun addListing(
        parent: LinearLayout,
        title: String,
        price: String,
        location: String,
        seller: String
    ) {

        val card =
            LinearLayout(this)

        card.orientation =
            LinearLayout.VERTICAL

        card.setPadding(
            15,
            15,
            15,
            15
        )

        card.setBackgroundColor(
            Color.WHITE
        )

        val titleView =
            TextView(this)

        titleView.text =
            title

        titleView.textSize =
            19f

        titleView.setTextColor(
            green
        )

        card.addView(
            titleView
        )

        val priceView =
            TextView(this)

        priceView.text =
            price

        priceView.textSize =
            18f

        card.addView(
            priceView
        )

        val locationView =
            TextView(this)

        locationView.text =
            "📍 $location"

        card.addView(
            locationView
        )

        val sellerView =
            TextView(this)

        sellerView.text =
            "Seller: $seller"

        card.addView(
            sellerView
        )

        val viewButton =
            Button(this)

        viewButton.text =
            "View Listing"

        viewButton.setOnClickListener {

            Toast.makeText(
                this,
                "Opening $title",
                Toast.LENGTH_SHORT
            ).show()
        }

        card.addView(
            viewButton
        )

        parent.addView(
            card,
            LinearLayout.LayoutParams(
                -1,
                -2
            ).apply {

                setMargins(
                    0,
                    8,
                    0,
                    8
                )
            }
        )
    }

    private fun showPostListing() {

        val root =
            LinearLayout(this)

        root.orientation =
            LinearLayout.VERTICAL

        root.setPadding(
            20,
            20,
            20,
            20
        )

        val title =
            TextView(this)

        title.text =
            "➕ Post a Listing"

        title.textSize =
            25f

        title.setTextColor(
            green
        )

        root.addView(title)

        val item =
            EditText(this)

        item.hint =
            "What are you selling?"

        root.addView(item)

        val price =
            EditText(this)

        price.hint =
            "Price e.g. ₦250,000"

        root.addView(price)

        val location =
            EditText(this)

        location.hint =
            "Location"

        root.addView(location)

        val description =
            EditText(this)

        description.hint =
            "Description"

        root.addView(
            description
        )

        val publish =
            Button(this)

        publish.text =
            "Publish Listing"

        publish.setOnClickListener {

            Toast.makeText(
                this,
                "Listing ready to publish. Firebase will be connected next.",
                Toast.LENGTH_LONG
            ).show()
        }

        root.addView(
            publish
        )

        val back =
            Button(this)

        back.text =
            "← Back to Marketplace"

        back.setOnClickListener {

            showMarketplace()
        }

        root.addView(
            back
        )

        setContentView(root)
    }
}
