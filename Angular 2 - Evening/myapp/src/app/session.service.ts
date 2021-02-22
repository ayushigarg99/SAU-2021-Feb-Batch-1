import { Injectable } from '@angular/core';
import { Session } from './modal/session'

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  

  sessionItems: Session[] = [
    {
      sessionname: 'VCS GIT Fundamentals',
      instructorname: 'Biresh Kumar Mishra',
      description:'Concepts of GIT and Version Control System with hands on practice'
    },
    {
      sessionname: 'RDBMS Concepts',
      instructorname: 'Tarun K.',
      description:'Data Modelling, ER Daigrams and Relational Models'
    },
    {
      sessionname: 'SQL Fundamentals',
      instructorname: 'Santosh Hegde',
      description:'Practice on MySQL Queries'
    }
  ]

  constructor() { }

  getSessions() {
    return this.sessionItems;
  }

  addSessions(session:Session) {
    this.sessionItems.push(session);
  }

  deleteSession(session:Session){
    for(let item of this.sessionItems){
        if((item.sessionname === session.sessionname) && (item.instructorname === session.instructorname) && (item.description===session.description)){
          this.sessionItems.splice(this.sessionItems.indexOf(item),1);
          return true;
        }

    }
    return false;
  }

  updateSession(index:number,session:Session){
    this.sessionItems[index].sessionname = session.sessionname;
    this.sessionItems[index].instructorname = session.instructorname;
    this.sessionItems[index].description = session.description;
  }

}