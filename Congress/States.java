public class States {
    String name;
    int seatsReceived;
    int numberOfTotalResidents = 0;
    int pv = 0;

    States(String val2, int val3, int val4, int val5) {
        name = val2;
        seatsReceived = val3;
        numberOfTotalResidents = val4;
        pv = val5;
    }

    States(String val2, int val3, int val4) {
        name = val2;
        seatsReceived = val3;
        pv = val4;
    }

    // States(int val1, String val2, int val3) {
    //     numberOfRemainingResidents = val1;
    //     name = val2;
    //     seatsReceived = val3;
    // }
}