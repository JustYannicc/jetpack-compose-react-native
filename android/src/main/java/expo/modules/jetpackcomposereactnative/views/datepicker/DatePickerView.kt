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
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.viewevent.ViewEventCallback

data class DatePickerProps(
    var modifier: ModifierProp = emptyList(),
    var confirmText: String? = null,
    var dismissText: String? = null,
    var tonalElevation: Int? = null,
    var showModeToggle: Boolean? = null,
)

class DatePickerView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private var props = mutableStateOf(DatePickerProps())
    private val onConfirm by EventDispatcher()

    init {
        ComposeView(context).also {
            it.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            it.setContent {
                DatePickerComposable(
                    props = props.value, 
                    onConfirmation = onConfirm
                )
            }
            addView(it)
        }
    }

    fun updateShowModeToggle(showModeToggle: Boolean){
        props.value = props.value.copy(showModeToggle = showModeToggle)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComposable(
    props: DatePickerProps,
    onConfirmation: ViewEventCallback<Map<String, Any>>
) {
    val modifier: Modifier = props.modifier.toModifier()
    val datePickerState = rememberDatePickerState()
    val openDialog = remember { mutableStateOf(true) }

    DatePickerDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        confirmButton = {
            TextButton(
                onClick = {
                    /* Selected date event */
                }
            ) {
                Text(props.confirmText ?: "OK")
            }
        },
        dismissButton = {
        TextButton(
            onClick = {
                openDialog.value = false
                }
            ) {
                Text(props.dismissText ?: "Cancel")
            }
        },
        tonalElevation = props.tonalElevation?.dp ?: AlertDialogDefaults.TonalElevation
    ) {
        DatePicker(
            state = datePickerState,
            showModeToggle = props.showModeToggle ?: true,
        )
    }    
}