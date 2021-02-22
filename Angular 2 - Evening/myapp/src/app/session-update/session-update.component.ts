import { Component, Inject, OnInit } from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SessionListComponent } from '../session-list/session-list.component'
import { SessionService } from '../session.service';
import { Session } from '../modal/session'

@Component({
  selector: 'app-session-update',
  templateUrl: './session-update.component.html',
  styleUrls: ['./session-update.component.scss']
})
export class SessionUpdateComponent implements OnInit {

  sessionForm!: FormGroup;


  constructor(@Inject(MAT_DIALOG_DATA) public data: {sessionname: string,instructorname:string,description:string,index:number}, 
            private sessionService: SessionService, private dialogRef:MatDialogRef<SessionListComponent>) { }

  ngOnInit(): void {
    this.sessionForm = new FormGroup({
      sessionname : new FormControl(this.data.sessionname, Validators.required),
      instructorname : new FormControl(this.data.instructorname, Validators.required),
      description : new FormControl(this.data.description)
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

  updateValue(){
    const session:Session = {
      sessionname : this.sessionname.value,
      instructorname: this.instructorname.value,
      description : this.description.value
    }
    this.sessionService.updateSession(this.data.index,session);
    this.dialogRef.close();
  }

}
