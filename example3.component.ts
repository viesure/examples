@Component({
    templateUrl: `
      <div *ngFor="let movie of movies">
        {{ movie.name }}
      </div>`,
})
export class Example3Component {
    private movies: Movie[];
    constructor() {
        this.movies = [
            {
                id: 0,
                name: 'Toy Story',
            },
            {
                id: 1,
                name: 'Finding Nemo',
            },
        ];
    }
}

this.movies = this.movies.concat([
    {
        id: 1234,
        'Harry Potter'
    }
]);