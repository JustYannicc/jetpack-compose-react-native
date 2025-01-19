package expo.modules.jetpackcomposereactnative.views.datepicker

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import expo.modules.jetpackcomposereactnative.common.ModifierProp
import expo.modules.jetpackcomposereactnative.common.toModifier
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView

data class DatePickerProps(
    var modifier: ModifierProp = emptyList(),
    var confirmText: String? = null,
    var dismissText: String? = null,
    var tonalElevation: Int? = null,
    var showModeToggle: Boolean = false,
)

class DatePickerView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private var props = mutableStateOf(DatePickerProps())
    private val onConfirm by EventDispatcher()
    private val onDismiss by EventDispatcher()

    init {
        ComposeView(context).also {
            it.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            it.setContent {
                DialogComposable(
                    props = props.value, 
                    onDismissRequest = onDismiss,
                    onConfirmation = onConfirm
                )
            }
            addView(it)
        }
    }


    fun updateTonalElevation(tonalElevation: Int) {
        props.value = props.value.copy(tonalElevation = tonalElevation)
    }

    fun updateConfirmText(confirmText: String) {
        props.value = props.value.copy(confirmText = confirmText)
    }

    fun updateDismissText(dismissText: String) {
        props.value = props.value.copy(dismissText = dismissText)
    }

    fun updateModifier(modifier: ModifierProp) {
        props.value = props.value.copy(modifier = modifier)
    }
}


@Composable
fun DatePickerComposable(props: DatePickerProps) {
    val modifier: Modifier = props.modifier.toModifier()
}