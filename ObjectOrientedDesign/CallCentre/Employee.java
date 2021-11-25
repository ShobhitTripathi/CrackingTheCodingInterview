package ObjectOrientedDesign.CallCentre;

public class Employee {
    private Call currentCall = null;
    protected Rank rank;

    /* start the conversation */
    public void receiveCall(Call call) { }

    /* issue is resolved, finish the call. */
    public void callCompleted() { }

    /* The issue has not been resolved. Escalate the call, and assign a new call to the employee. */
    public void escalateAndReassign() {  }

    /* Assign a new call to an employee, if the employee is free. */
    public boolean assignNewCall () { return true;}

    /* Returns whether or not the employee is free. */
    public boolean isFree() { return currentCall == null;    }

    public Rank getRank() { return rank; }
}
