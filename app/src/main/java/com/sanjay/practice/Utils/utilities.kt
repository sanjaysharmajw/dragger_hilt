package com.sanjay.practice.Utils

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utilities {

    /*    // Show a toast message
        context.showToast("Hello, World!")

        // Format a date
        val formattedDate = Date().formatDate()

        // Check if a string is null or empty
        val isEmpty = "Hello".isNullOrEmptyOrBlank()

        // Capitalize the first letter of a string
        val capitalized = "hello".capitalizeFirstLetter()

        // Get current time
        val currentTime = KotlinUtils.getCurrentTime()

        // Convert a list of strings to a comma-separated string
        val stringList = listOf("apple", "banana", "cherry")
        val commaSeparated = stringList.toCommaSeparatedString()

        // Generate a random integer between 1 and 100
        val randomInt = KotlinUtils.getRandomIntInRange(1, 100)

        // Run a block of code safely
        val result = KotlinUtils.runSafely {
            // Code that might throw an exception
            "Success"
        }*/


    fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun Date.formatDate(format: String = "yyyy-MM-dd HH:mm:ss"): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(this)
    }

    fun String?.isNullOrEmptyOrBlank(): Boolean = this.isNullOrEmpty() || this.isBlank()
    fun String.capitalizeFirstLetter(): String =
        if (this.isNotEmpty()) this[0].uppercase() + this.substring(1) else this

    fun getCurrentTime(format: String = "HH:mm:ss"): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date())
    }

    fun List<String>.toCommaSeparatedString(): String = this.joinToString(", ")
    fun getRandomIntInRange(start: Int, end: Int): Int = (start..end).random()
    fun <T> runSafely(block: () -> T): T? {
        return try {
            block()
        } catch (e: Exception) {
            e.printStackTrace() // Log the exception
            null
        }
    }
}
