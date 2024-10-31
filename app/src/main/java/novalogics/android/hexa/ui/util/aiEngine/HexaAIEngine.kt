package novalogics.android.hexa.ui.util.aiEngine

import android.os.Build
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HexaAIEngine {

    fun getResponse(userInput: String): String {
        return when {
            userInput.contains("hi", ignoreCase = true) ||
            userInput.contains("hey", ignoreCase = true) ||
             userInput.contains("hello", ignoreCase = true) -> "Hello! How can I assist you today?"

            userInput.contains("help", ignoreCase = true) -> "I can help you with simple tasks. Try asking me something!"
            userInput.contains("time", ignoreCase = true) -> getCurrentTime()
            userInput.contains("bye", ignoreCase = true) -> "Goodbye! Have a great day!"
            else -> "I'm here to chat. Feel free to ask me anything!"
        }
    }

    private fun getCurrentTime(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For Android O and above
            val currentTime = java.time.LocalTime.now()
            "The current time is ${currentTime.format(java.time.format.DateTimeFormatter.ofPattern("hh:mm a"))}"
        } else {
            // For older Android versions
            val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
            val currentTime = Date()
            "The current time is ${dateFormat.format(currentTime)}"
        }
    }
}
