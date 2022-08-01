import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ManagerService } from '../../services/manager.service';
import { FootballClub } from 'src/app/models/FootballClub';

@Component({
  selector: 'app-clubs',
  templateUrl: './clubs.component.html',
  styleUrls: ['./clubs.component.css']
})

export class ClubsComponent implements OnInit {
  clubs:FootballClub[];

  constructor(private managerService:ManagerService) { }

  ngOnInit(): void {
    this.managerService.getClubs().subscribe((clubs)=>{
      this.clubs = clubs;
    });
  }

  onClickSortByWins(){
    this.managerService.getClubsSortedByWins().subscribe((clubs)=>{
      this.clubs = clubs;
    });
  }

  onClickSortByGoals(){
    this.managerService.getClubsSortedByGoals().subscribe((clubs)=>{
      this.clubs=clubs;
    });
  }

}
