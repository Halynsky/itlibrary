import { Author } from "@api/models/Author";
import { Publisher } from "@api/models/Publisher";
import { InventoryStatus } from "@api/models/enums/InventoryStatus";

export class Book {
  id!: number;
  title!: string;
  authors: Author[] = []
  publisher!: Publisher;
  InventoryStatus!: InventoryStatus;
  price!: number;
  rating!: number;
}
