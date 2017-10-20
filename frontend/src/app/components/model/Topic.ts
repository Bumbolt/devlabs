
import {Tag} from './Tag';
import {User} from './User';
import {Session} from './Session';

export class Topic {
  title: string;
  description: string;
  tags: Tag[];
  subscribers: User[];
  session: Session[];
}
