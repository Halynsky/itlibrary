import { Book } from "@api/models/Book";

export class Publisher {
  id!: number;
  name!: string;
  books: Book [] = [];
  founded!: string;
}
