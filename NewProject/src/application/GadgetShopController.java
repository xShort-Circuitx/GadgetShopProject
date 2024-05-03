package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.layout.GridPane;

import application.GadgetShop;


public class GadgetShopController {	
	private GadgetShop gadgetShop;
	
	public GadgetShopController() {
        this.gadgetShop = new GadgetShop(); // Create an instance of GadgetShop
    }
	
	@FXML
	private GridPane gridPane;
	@FXML
	private TextField modelTextField;
	@FXML
	private TextField priceTextField;
	@FXML
	private TextField weightTextField;
	@FXML
	private TextField sizeTextField;
	@FXML
	private TextField creditTextField;
	@FXML
	private TextField memoryTextField;
	@FXML
	private Button addMobileButton;
	@FXML
	private Button addMP3Button;
	@FXML
	private Button clearButton;
	@FXML
	private TextField displayNumTextField;
	@FXML
	private TextField phoneTextField;
	@FXML
	private TextField durationTextField;
	@FXML
	private TextField downloadTextField;
	@FXML
	private Button displayAllButton;
	@FXML
	private Button CallButton;
	@FXML
	private Button DownloadButton;

	// Event Listener on Button[#addMobileButton].onAction
	@FXML
	public void handleAddMobile() {
        String model = modelTextField.getText();
        String priceStr = priceTextField.getText();
        String weightStr = weightTextField.getText();
        String size = sizeTextField.getText();
        String creditStr = creditTextField.getText();

        if (model.isEmpty() || priceStr.isEmpty() || weightStr.isEmpty() || size.isEmpty() || creditStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            double weight = Double.parseDouble(weightStr);
            int credit = Integer.parseInt(creditStr);

            GadgetShop.Gadgets.add(new Mobile(model, price, (int) weight, size, credit));
            showAlert(Alert.AlertType.INFORMATION, "Success", "Mobile added successfully.");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input. Please enter valid numbers.");
        }
    }
	
	// Event Listener on Button[#addMP3Button].onAction
	@FXML
	 public void handleAddMP3() {
        String model = modelTextField.getText();
        String priceStr = priceTextField.getText();
        String weightStr = weightTextField.getText();
        String size = sizeTextField.getText();
        String memoryStr = memoryTextField.getText();

        if (model.isEmpty() || priceStr.isEmpty() || weightStr.isEmpty() || size.isEmpty() || memoryStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            double weight = Double.parseDouble(weightStr);
            int memory = Integer.parseInt(memoryStr);

            GadgetShop.Gadgets.add(new MP3(model, price, (int) weight, size, memory));
            showAlert(Alert.AlertType.INFORMATION, "Success", "MP3 player added successfully.");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input. Please enter valid numbers.");
        }
    }
	// Event Listener on Button[#clearButton].onAction
	@FXML
	public void handleClear() {
        modelTextField.clear();
        priceTextField.clear();
        weightTextField.clear();
        sizeTextField.clear();
        creditTextField.clear();
        memoryTextField.clear();
        displayNumTextField.clear();
        phoneTextField.clear();
        durationTextField.clear();
        downloadTextField.clear();
    }
	// Event Listener on Button[#displayAllButton].onAction
	@FXML
	public void handleDisplayAll() {
        for (Gadget gadget : GadgetShop.Gadgets) {
            gadget.display();
        }
    }
	
	// Event Listener on Button[#CallButton].onAction
	@FXML
	public void MakeCall() {
        // Check if display number and duration fields are empty
        String displayNum = displayNumTextField.getText().trim();
        String duration = durationTextField.getText().trim();
        
        if (displayNum.isEmpty() || duration.isEmpty()) {
            // Show an alert if any of the fields are empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both display number and duration.");
            alert.showAndWait();
            return;
        }
        
        int displayNum2 = Integer.parseInt(displayNum);
        int duration2 = Integer.parseInt(duration);
        
        
        Mobile mob =(Mobile)GadgetShop.Gadgets.get(displayNum2);
        // Check call credit left
        double callCreditLeft = mob.getCallingCredit(); // You need to implement this method
        
        // Parse duration to double
        
        
        if (callCreditLeft >= duration2) {
            // If call credit is greater than or equal to duration, show success message
        	mob.setCallingCredit((int)callCreditLeft-duration2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Call successfully initiated!");
            alert.showAndWait();
        } else {
            // Otherwise, show an alert indicating insufficient call credit
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Insufficient call credit!");
            alert.showAndWait();
        }
    }

    @FXML
    public void DownloadMusic() {
    	
    	if(downloadTextField.getText().isEmpty()||displayNumTextField.getText().isEmpty())
    	{
    		showAlert(Alert.AlertType.ERROR, "Error", "Enter values in download size and display field");
    	}
    	else
    	{
    		int downloadSize = Integer.parseInt(downloadTextField.getText());
    		int display = Integer.parseInt(displayNumTextField.getText());
    		MP3 MP3player = (MP3)GadgetShop.Gadgets.get(display);
    		
    		if(MP3player.getAvailableMemory()>=downloadSize)
    		{
    			MP3player.setMemory(MP3player.getAvailableMemory()-downloadSize);
    			showAlert(Alert.AlertType.INFORMATION,"Success", "Song Downloaded!");
    			
    		}
    		else
    		{
    			showAlert(Alert.AlertType.ERROR,"Error", "Insufficient memory");
    		}
    	}
        
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
