import { Component, OnInit } from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { SessionListComponent } from '../session-list/session-list.component'
import { SessionService } from '../session.service';
import { Session } from '../modal/session'

@Component({
  selector: 'app-session-add',
  templateUrl: './session-add.component.html',
  styleUrls: ['./session-add.component.scss']
})
export class SessionAddComponent implements OnInit {

 
  sessionForm!: FormGroup;
  sessionToDelete:Session | undefined;
  

  constructor(private sessionService:SessionService, private dialogRef:MatDialogRef<SessionListComponent>) {  }

  ngOnInit(): void {
    this.sessionForm = new FormGroup({
      sessionname : new FormControl('', Validators.required),
      instructorname : new FormControl('', Validators.required),
      description : new FormControl('')
    });
  }

  get sessionname() {
    return this.sessionForm.get('sessionname') as FormControl;
  }

  get instructorname() {
    return this.sessionForm.get('instructorname') as FormControl;
  }


  get description() {
    return this.sessionForm.get('description') as FormControl;
  }

  addToList(){
    const session:Session = {
      sessionname : this.sessionname.value,
      instructorname: this.instructorname.value,
      description : this.description.value
    }
    this.sessionService.addSessions(session);
    this.dialogRef.close();
  }

  deleteSession(sessionToDelete: Session){
    this.sessionService.deleteSession(sessionToDelete) 
  }

}
