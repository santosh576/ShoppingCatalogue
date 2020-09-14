package com.ShoppingCatalogue.ModelClass;

import java.util.ArrayList;

public class ValidationMessage {

	private ArrayList<String> message;
	
	ValidationMessage(){
			
		}
		
		public ValidationMessage(ArrayList<String> message) {
			super();
			this.message = message;
		}


		public ArrayList<String> getMessage() {
			return message;
		}

		public void setMessage(ArrayList<String> message) {
			this.message = message;
		}
}
