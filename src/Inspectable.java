public interface Inspectable {

    void recordInspectionResult(String result);

    String getInspectionResult();

    boolean isClosedForInspection();
}