import {Component} from '@angular/core';
import {Outcome} from './outcome';

@Component({
  selector: 'app-root',
  templateUrl: './outcome.component.html',
  styleUrls: ['./outcome.component.css']
})
export class OutcomeComponent {
  title = "Outcomes";
  outcome: Outcome = new Outcome(0, '', '', 0);

  addOutcome() {

  }
}
