@Component({
    template:
        `<div>
           <h3>Example</h3>
           <div class="alert alert-danger" *ngIf="logged == false">
             You are not allowed here
           </div>
           <div class="panel">
             <div class="panel-header">
               {{ name == undefined ? 'John Doe' : name }}
             </div>
           </div>
         </div>`,
})
export class Example1Component {
    logged: boolean = true;
    name: string = null;
}