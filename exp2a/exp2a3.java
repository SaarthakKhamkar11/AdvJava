interface IUser { 
    void readPost(); 
} 

interface IWriter { 
    void writePost(); 
    void editPost(); 
} 

interface IAdmin { 
    void blockUser(); 
    void deletePost(); 
} 

class Reader implements IUser { 
    @Override 
    public void readPost() { 
        System.out.println("Reader is reading a post."); 
    } 
} 

class Writer implements IUser, IWriter { 
    @Override 
    public void readPost() { 
        System.out.println("Writer is reading a post."); 
    } 
    @Override 
    public void writePost() { 
        System.out.println("Writer is writing a post."); 
    } 
    @Override 
    public void editPost() { 
        System.out.println("Writer is editing a post."); 
    } 
} 

class Admin implements IUser, IWriter, IAdmin { 
    @Override 
    public void readPost() { 
        System.out.println("Admin is reading a post.");
    } 
    @Override 
    public void writePost() { 
        System.out.println("Admin is writing a post."); 
    } 
    @Override 
    public void editPost() { 
        System.out.println("Admin is editing a post."); 
    } 
    @Override 
    public void blockUser() { 
        System.out.println("Admin is blocking a user."); 
    } 
    @Override 
    public void deletePost() { 
        System.out.println("Admin is deleting a post."); 
    } 
} 

public class exp2a3 { 
    public static void main(String[] args) { 
        System.out.println(""); 
        IUser reader = new Reader(); 
        reader.readPost();
        System.out.println(""); 
        Writer writer = new Writer(); 
        writer.readPost(); 
        writer.writePost(); 
        writer.editPost(); 
        System.out.println(""); 
        Admin admin = new Admin(); 
        admin.readPost(); 
        admin.writePost(); 
        admin.editPost(); 
        admin.blockUser(); 
        admin.deletePost(); 
    } 
} 