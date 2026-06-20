interface Document {
    void open();
    void save();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Word Document..."); }
    @Override
    public void save() { System.out.println("Saving Word Document..."); }
    @Override
    public void close() { System.out.println("Closing Word Document..."); }
}

class PdfDocument implements Document {
    @Override
    public void open() { System.out.println("Opening PDF Document..."); }
    @Override
    public void save() { System.out.println("Saving PDF Document..."); }
    @Override
    public void close() { System.out.println("Closing PDF Document..."); }
}

class ExcelDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Excel Document..."); }
    @Override
    public void save() { System.out.println("Saving Excel Document..."); }
    @Override
    public void close() { System.out.println("Closing Excel Document..."); }
}


abstract class DocumentFactory {

    public abstract Document createDocument();

    public void manageNewDocument() {
        
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample{
    public static void main(String[] args) {
        
        System.out.println("Client interacting with Word ");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        System.out.println("\n 2. Client interacting with PDF ");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println("\n 3. Client using the Creator's shared business logic");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.manageNewDocument();
    }
}