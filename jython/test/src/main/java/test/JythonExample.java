package test;
import org.python.util.PythonInterpreter;
import org.python.core.*;

public class JythonExample {

    public static void main(String[] args) {
        // Sample Java array
        int[] javaArray = {1, 2, 3, 4, 5};

        // Initialize Python interpreter
        PythonInterpreter interpreter = new PythonInterpreter();

        // Load and execute the external Python script file
        interpreter.execfile("/Users/sanjju/projects/b-spline/jython/sum.py"); // Path to compute.py

        // Convert Java array to PyList
        PyList pyList = new PyList();
        for (int num : javaArray) {
            pyList.append(new PyInteger(num));
        }

        // Get the Python function defined in compute.py
        PyFunction computeSumFunc = (PyFunction) interpreter.get("compute_sum", PyFunction.class);

        // Call the Python function with the Java array as argument
        PyObject result = computeSumFunc.__call__(pyList);

        // Convert result to Java int
        int sum = result.asInt();

        System.out.println("Sum of array elements: " + sum);
    }
}
