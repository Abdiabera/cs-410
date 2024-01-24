package cs410;
public class Duration {
    public int seconds;
    //private  int minutes;
    //private  int hours;
    //we have to create duration object for the component duration (hours, second, minutes)
    public Duration(int seconds) {
        this.seconds = seconds;
        //  this.minutes = minutes;
        //this.hours = hours;
        //this.minutes = minutes;
        //this.hours = hours;
    }
    /*we have to create duration from the total number of seconds and we have to return duration obhject
     */
    public static Duration of(int TSecond){

        return new Duration(TSecond);
    }
    //we have to create a duration object from hr, minutes, second  and return duration onject
    public static Duration of( int hours, int minutes, int seconds)
    {
        int A=   hours * 60 * 60 ;

        int B = minutes * 60 ;

        int tot = A + B + seconds ;

        return new Duration(tot);

    }
    // this used to add two duration and return to total second
    public Duration add(Duration Abdi){
        int Tsecond = this.seconds() + Abdi.seconds();
        return Duration.of(Tsecond);
    }
    //  it retuns to total seconds in the duration
    public int seconds() {
        return  seconds;
    }
    /* according the given isntruction we have to override toString

     */
    @Override
    public String toString() {

        int Totsec = this.seconds();


        int hours = Totsec/3600;
        int RSec = Totsec % 3600;
        int minutes = RSec / 60;
        int seconds = RSec % 60;
        RSec = Totsec -(hours*3600);

        return String.format("%d:%02d:%02d",hours,minutes, seconds);
    }
}
