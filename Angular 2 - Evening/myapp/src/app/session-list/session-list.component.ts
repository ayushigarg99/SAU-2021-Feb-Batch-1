import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Session } from '../modal/session';
import { SessionAddComponent } from '../session-add/session-add.component';
import { SessionUpdateComponent } from '../session-update/session-update.component';
import { SessionService } from '../session.service'

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.scss']
})
export class SessionListComponent implements OnInit {

  sessionItems!: Session[];

  

  constructor(private sessionService:SessionService, private dialog:MatDialog) {}

  ngOnInit(): void {
    this.sessionItems = this.sessionService.getSessions();
  }

  addSession(){
    this.dialog.open(SessionAddComponent, {
      width:'300px'
    });
  }

  updateSession(i:number){
    this.dialog.open(SessionUpdateComponent, {
      width:'300px',
      data: { sessionname: this.sessionService.sessionItems[i].sessionname, 
              instructorname: this.sessionService.sessionItems[i].instructorname,
              description: this.sessionService.sessionItems[i].description,
              index:i
           },
      
    });
  }

  deleteSession(session:Session){
    if(this.sessionService.deleteSession(session)){
      return this.sessionService.getSessions();
    }
    return this.sessionService.getSessions();
  }

}
