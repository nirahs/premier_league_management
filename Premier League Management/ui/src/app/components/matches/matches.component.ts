import { Component, OnInit } from '@angular/core';
import { ManagerService } from 'src/app/services/manager.service';
import { Match } from '../../models/Match';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  matches:Match[];
  date:string='';
  invalid:boolean=false;

  constructor(private managerService:ManagerService) { }

  ngOnInit(): void {
    this.showMatches();
  }

  showMatches(){
    this.managerService.getMatches().subscribe((matches)=>{
      this.matches=matches;
    })
  }

  onClickCreateRandomMatch(){
    this.managerService.getRandomMatches().subscribe((matches)=>{
      this.matches=matches;
      console.log(matches);
    })
  }

  onClickGetMatchesAtSpecificDate(){
    this.managerService.getMatchesAtSpecificDate(this.date).subscribe((matches)=>{
      if (matches.length===0){
        this.showMatches();
        this.invalid = true;
      }else{
        this.invalid = false;
        this.matches=matches;
      }
    });
  }

  onClickGetMatchesSortedByDate(){
    this.managerService.getMatchesSortedByDate().subscribe((matches)=>{
      this.matches=matches;
    })
  }


}
