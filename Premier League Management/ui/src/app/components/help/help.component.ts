import { Component, OnInit } from '@angular/core';
import { Help } from '../../models/Help';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})

export class HelpComponent implements OnInit {
  consHelps:Help[];
  guiHelps:Help[];

  constructor() { }

  ngOnInit(): void {
    this.consHelps = [
      {
        heading:"Console Instruction",
        img:"../../assets/HelpConsole/wellcomeMsg.png",
        paragraph:"The above picture shows what are the things a user can do with this program. So user can call those methods complete his necessary task. User can add a club by choosing one or remove club by choosing two or view the statistics of each club separetly by choosing three or view all clubs statistics in one table view by choosing four or update a club by creating a match between two clubs by choosing five or user can open gui by choosing option six or user can exit by choosing option seven."
      },
      {
        heading:"Add Club",
        img:"../../assets/HelpConsole/addingAClub.png",
        paragraph:"The above picture shows how a user can add a club very easily. When a user is adding a club user must add values for club name, club location, club founded year. Those are necessary to create a club. Later when user updating a club or creating random match between two clubs, club statistic will automatically get updated."
      },{
        heading:"Remove Club",
        img:"../../assets/HelpConsole/deletingAClub.png",
        paragraph:"The above picture shows how a user can remove a club. To remove a club user have to select a club by entering their valid number. Then the system will ask the user again to confirm. If user entered \"yes\" system will remove the club from the sytem."
      },{
        heading:"Display Statistics",
        img:"../../assets/HelpConsole/displayingAClubStats.png",
        paragraph:"The above picture shows how a user can view statistics of each club seperatly. It will show all of the data about that club. To choose a club user have enter the number."
      },{
        heading:"Display Table View",
        img:"../../assets/HelpConsole/displayingTable.png",
        paragraph:"The above picture shows how a user can open the table view which will show all of the clubs statistics. To use this user have to enter four."
      },{
        heading:"Update Club",
        img:"../../assets/HelpConsole/update.png",
        paragraph:"The above picture shows how a user can update a club. Here user have to create a match between two club then user have to enter the score. Then the sytem will update the participated clubs. Gui, statistics table view and induvidual statistics will show the updated values."
      },{
        heading:"Open Gui",
        img:"../../assets/HelpConsole/openGUI.png",
        paragraph:"The above picute shows intruction to run gui. User have to follow the instruction and the web page will open automaticlly."
      },{
        heading:"Exit",
        img:"../../assets/HelpConsole/exit.png",
        paragraph:"The above picture how user can exit the prgram without corrupting it. Best practise to follow."
      },
    ];

    this.guiHelps=[
      {
        heading:"Club Table",
        img:"../../assets/HelpGui/clubTable.png",
        paragraph:"The above picture show the club table in gui. Here when user add a club or update a club here values will get automatically updated"
      },
      {
        heading:"Club Btns",
        img:"../../assets/HelpGui/clubBtns.png",
        paragraph:"The above buttons show the button that are used to sort the values based on club wins and bases on difference between number of goals scored and goal recived."
      },
      {
        heading:"Match Table",
        img:"../../assets/HelpGui/matchTable.png",
        paragraph:"The above image shows match table in gui."
      },
      {
        heading:"Match Btns",
        img:"../../assets/HelpGui/matchBtns.png",
        paragraph:"The above image shows buttons and form that are used to created random match between random club, form is used to get match based on the specific date. Get matches sorted by date button is used to sort and show matches based on date"
      },
    ];
  }

}
