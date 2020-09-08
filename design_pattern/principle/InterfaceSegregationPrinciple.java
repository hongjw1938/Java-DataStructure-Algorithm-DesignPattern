package principle;

public class InterfaceSegregationPrinciple {
}

class Document{

}

interface Machine{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine{
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashioedPrinter implements  Machine{
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

// 단일 Interface 구현
interface  Printer{
    void print(Document d);
}

interface  Scanner{
    void scan(Document d);
}

// 상위 두 개의 Interface를 한 번에 사용하도록 하고 싶다면
// 아래 처럼 만들어서 아래를 바로 상속받도록 하면 된다.
interface MultiFunctionDevice extends Printer, Scanner{}

class MultiFunctionMachine implements MultiFunctionDevice{
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}

// YAGNI = You Ain't Going to Need It
// Printer에는 Scan이 필요없다.

class JustAPrinter implements Printer{
    @Override
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner{
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}