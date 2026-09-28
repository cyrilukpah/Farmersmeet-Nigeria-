package ng.farmersmeet.nigeria

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val green = Color.rgb(23, 107, 58)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showWelcome()
    }

    private fun showWelcome() {

        val layout = LinearLayout(this)

        layout.orientation = LinearLayout.VERTICAL

        layout.gravity = Gravity.CENTER

        layout.setPadding(
            30,
            30,
            30,
            30
        )

        layout.setBackgroundColor(
            Color.rgb(244, 248, 245)
        )

        val logo = TextView(this)

        logo.text = "🌱"

        logo.textSize = 65f

        logo.gravity = Gravity.CENTER

        layout.addView(logo)

        val title = TextView(this)

        title.text = "FarmersMeet Nigeria"

        title.textSize = 28f

        title.setTextColor(green)

        title.gravity = Gravity.CENTER

        layout.addView(title)

        val subtitle = TextView(this)

        subtitle.text =
            "Where Farmers Meet Buyers"

        subtitle.textSize = 16f

        subtitle.gravity = Gravity.CENTER

        layout.addView(subtitle)

        val space = Space(this)

        layout.addView(
            space,
            LinearLayout.LayoutParams(
                1,
                35
            )
        )

        val login = Button(this)

        login.text = "Login"

        login.setOnClickListener {

            showLogin()

        }

        layout.addView(
            login,
            LinearLayout.LayoutParams(
                -1,
                60
            )
        )

        val signup = Button(this)

        signup.text = "Create Account"

        signup.setOnClickListener {

            showSignup()

        }

        layout.addView(
            signup,
            LinearLayout.LayoutParams(
                -1,
                60
            )
        )

        val browse = Button(this)

        browse.text = "Browse Marketplace"

        browse.setOnClickListener {

            showMarketplace()

        }

        layout.addView(
            browse,
            LinearLayout.LayoutParams(
                -1,
                60
            )
        )

        setContentView(layout)
    }

    private fun showLogin() {

        val layout = createForm(
            "Welcome Back"
        )

        val email = EditText(this)

        email.hint = "Email address"

        email.inputType =
            android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

        layout.addView(email)

        val password = EditText(this)

        password.hint = "Password"

        password.inputType =
            android.text.InputType.TYPE_CLASS_TEXT or
            android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD

        layout.addView(password)

        val login = Button(this)

        login.text = "Login"

        login.setOnClickListener {

            Toast.makeText(
                this,
                "Firebase login will be connected next.",
                Toast.LENGTH_SHORT
            ).show()
        }

        layout.addView(login)

        val signup = Button(this)

        signup.text = "Create a new account"

        signup.setOnClickListener {

            showSignup()
        }

        layout.addView(signup)

        val back = Button(this)

        back.text = "Back"

        back.setOnClickListener {

            showWelcome()
        }

        layout.addView(back)

        setContentView(layout)
    }

    private fun showSignup() {

        val layout = createForm(
            "Create Your Account"
        )

        val name = EditText(this)

        name.hint = "Full name"

        layout.addView(name)

        val email = EditText(this)

        email.hint = "Email address"

        layout.addView(email)

        val phone = EditText(this)

        phone.hint = "Phone / WhatsApp"

        layout.addView(phone)

        val password = EditText(this)

        password.hint = "Create password"

        password.inputType =
            android.text.InputType.TYPE_CLASS_TEXT or
            android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD

        layout.addView(password)

        val accountType = Spinner(this)

        val types = arrayOf(
            "Buyer",
            "Seller",
            "Farmer / Producer"
        )

        accountType.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                types
            )

        layout.addView(accountType)

        val signup = Button(this)

        signup.text = "Create Account"

        signup.setOnClickListener {

            Toast.makeText(
                this,
                "Firebase registration will be connected next.",
                Toast.LENGTH_SHORT
            ).show()
        }

        layout.addView(signup)

        val back = Button(this)

        back.text = "Back"

        back.setOnClickListener {

            showWelcome()
        }

        layout.addView(back)

        setContentView(layout)
    }

    private fun createForm(
        heading: String
    ): LinearLayout {

        val layout =
            LinearLayout(this)

        layout.orientation =
            LinearLayout.VERTICAL

        layout.setPadding(
            30,
            40,
            30,
            30
        )

        layout.setBackgroundColor(
            Color.rgb(244, 248, 245)
        )

        val title =
            TextView(this)

        title.text = heading

        title.textSize = 26f

        title.setTextColor(green)

        title.setPadding(
            0,
            0,
            0,
            25
        )

        layout.addView(title)

        return layout
    }

    private fun showMarketplace() {

        val layout =
            LinearLayout(this)

        layout.orientation =
            LinearLayout.VERTICAL

        layout.setPadding(
            20,
            20,
            20,
            20
        )

        val title =
            TextView(this)

        title.text =
            "🌱 FarmersMeet Marketplace"

        title.textSize = 25f

        title.setTextColor(green)

        layout.addView(title)

        val search =
            EditText(this)

        search.hint =
            "Search livestock, feeds, equipment..."

        layout.addView(search)

        val categories =
            arrayOf(
                "🐄 Livestock",
                "🐖 Pigs",
                "🐔 Poultry",
                "🌾 Feeds",
                "🚜 Equipment",
                "🩺 Veterinary Services"
            )

        categories.forEach {

            val button =
                Button(this)

            button.text = it

            layout.addView(button)
        }

        val post =
            Button(this)

        post.text =
            "+ Post a Listing"

        layout.addView(post)

        val back =
            Button(this)

        back.text =
            "← Back"

        back.setOnClickListener {

            showWelcome()
        }

        layout.addView(back)

        setContentView(layout)
    }
}
