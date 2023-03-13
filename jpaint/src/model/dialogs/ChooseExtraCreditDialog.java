package model.dialogs;

import model.interfaces.IApplicationState;
import model.shapes.ExtraCredit;
import view.interfaces.IDialogChoice;

public class ChooseExtraCreditDialog implements IDialogChoice<ExtraCredit>{

    private final IApplicationState applicationState;

    public ChooseExtraCreditDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Extra Credit";
    }

    @Override
    public String getDialogText() {
        return "Select an EC option from the menu below:";
    }

    @Override
    public ExtraCredit[] getDialogOptions() {
        return ExtraCredit.values();
    }

    @Override
    public ExtraCredit getCurrentSelection() {
        return applicationState.getActiveExtraCredit();
    }
}
