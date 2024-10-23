package novalogics.android.harrysspellbook.ui.screen.home

data class HomeUiState(
    val isLoading: Boolean = false,
    val data: String = "",
    val error: String? = null
)
