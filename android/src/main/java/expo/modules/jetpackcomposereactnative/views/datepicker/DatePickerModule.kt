package expo.modules.jetpackcomposereactnative.views.datepicker

import expo.modules.jetpackcomposereactnative.common.ModifierProp
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class DatePickerModule : Module() {
    override fun definition() = ModuleDefinition {
        Name("DatePickerView")

        View(DatePickerView::class) {
            Prop("tonalElevation") { view: DatePickerView, prop: Int ->
                view.updateTonalElevation(prop)
            }
            Prop("confirmText") { view: DatePickerView, prop: String ->
                view.updateConfirmText(prop)
            }
            Prop("dismissText") { view: DatePickerView, prop: String ->
                view.updateDismissText(prop)
            }
            Prop("modifier") { view: DatePickerView, prop: ModifierProp ->
                view.updateModifier(prop)
            }
        }
    }
}
