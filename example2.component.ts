@Component({
    template: '<div *ngFor="let list of lists"> ... </div>',
})
export class Example2Component implements OnInit {
    private listObservable: Observable<any>;
    ngOnInit() {
        this.listObservable = this.listService
            .getAllLists()
            .subscribe((res: any) => (this.lists = res));
    }
}