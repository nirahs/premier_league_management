import { FootballClub } from "./FootballClub";
import { Date } from "./Date";

export interface Match{
    club1:FootballClub,
    club2:FootballClub,
    club1Score:number,
    club2Score:number,
    matchDate:Date,
}
