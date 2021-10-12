import java.io.*;
public class Survey extends Form {
	public void display(){
		for(int i = 0; i < this.questions.size(); i++){
			System.out.println("Question " + (i + 1) + ": ");
			this.questions.get(i).display();
			
			System.out.println("");
		}
	}
	public void save(){
		/*
		 * Stores all questions in a java serialized format
		 */
		try{
			File file = new File(this.getTitle() + ".ser");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream fileOut = new FileOutputStream(file, false);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for(int i = 0; i < this.questions.size(); i++){
				out.writeObject(this.questions.get(i));
			}
			out.close();
			fileOut.close();
		}catch(IOException i){
			i.printStackTrace();
		}
	}
}