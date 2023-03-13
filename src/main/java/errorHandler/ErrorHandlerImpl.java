package errorHandler;

import javax.swing.*;

public class ErrorHandlerImpl implements ErrorHandler{
    @Override
    public void generateError(ErrorType errorType) {
        JFrame frame = new JFrame();
        if (errorType == ErrorType.NOT_EMPLOYEE){
            JOptionPane.showMessageDialog(frame,"Employee not selected!");
        }else if (errorType == ErrorType.NOT_TASK){
            JOptionPane.showMessageDialog(frame,"Task not selected!");
        }else if (errorType == ErrorType.EMPTY){
            JOptionPane.showMessageDialog(frame,"No field can be left empty!");
        }else if (errorType == ErrorType.NOTHING_SELECTED){
            JOptionPane.showMessageDialog(frame,"No field selected!");
        }else if(errorType == ErrorType.MINUS){
            JOptionPane.showMessageDialog(frame,"Salary cannot be less than 1!");
        }
    }

    @Override
    public void generateError(ErrorType errorType, String data) {
        JFrame frame = new JFrame();
    }
}
