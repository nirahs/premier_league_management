import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { FootballClub } from '../models/FootballClub';
import { Match } from '../models/Match';


@Injectable({
  providedIn: 'root'
})
export class ManagerService {
  // Clubs
  clubsURL = "http://localhost:9000/clubsPoints";
  clubsSortedByWinsURL = "http://localhost:9000/clubsWins";
  clubsSortedByGoalsURL = "http://localhost:9000/clubsGoals";
  // Matches
  matchesURL = "http://localhost:9000/matches";
  matchesAtDateURL = "http://localhost:9000/matches"
  matchesRandomURL =  "http://localhost:9000/randomMatch";
  matchesSortedByDateURL  = "http://localhost:9000/matchesDate"

  constructor(private http:HttpClient) { }

  getClubs():Observable<FootballClub[]>{
    return this.http.get<FootballClub[]>(this.clubsURL);
  }

  getClubsSortedByWins():Observable<FootballClub[]>{
    return this.http.get<FootballClub[]>(this.clubsSortedByWinsURL);
  }

  getClubsSortedByGoals():Observable<FootballClub[]>{
    return this.http.get<FootballClub[]>(this.clubsSortedByGoalsURL);
  }

  getMatches():Observable<Match[]>{
    return this.http.get<Match[]>(this.matchesURL);
  }

  getRandomMatches():Observable<Match[]>{
    return this.http.get<Match[]>(this.matchesRandomURL);
  }

  getMatchesAtSpecificDate(date:string):Observable<Match[]>{
    const url = `${this.matchesAtDateURL}/${date}`
    return this.http.get<Match[]>(url);
  }

  getMatchesSortedByDate():Observable<Match[]>{
    return this.http.get<Match[]>(this.matchesSortedByDateURL)
  }

}
