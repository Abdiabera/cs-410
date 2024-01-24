package cs410.webfilmz;
/*

        Author : Professor Ryan Culpepper

        Student name : Abdi Abera
        Subject: cs410
        Date : 10/12/2023

        */
/* Express preferences about films (directors and genres, specifically)
 */
public interface ILikeFilm {
    // Do we like the given director or genre?
    public boolean isLikedDirector(String director);
    public boolean isLikedGenre(String genre);
}
