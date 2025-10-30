public class ProcessFiles {
    private String stdInput;
    private String stdOutput;
    private String stdError;
    private String executable;

    public ProcessFiles(String StdInput, String StdOutput, String StdError, String Executable) {
        this.stdInput = StdInput;
        this.stdOutput = StdOutput;
        this.stdError = StdError;
        this.executable = Executable;
    }

    public ProcessFiles(String Executable) {
        this.stdInput = "STDIN";
        this.stdOutput = "STDOUT";
        this.stdError = "STDERR";
        this.executable = Executable;
    }

    public String getExecutable() {
        return executable;
    }
}
