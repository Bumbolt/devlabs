export interface Topic {
  $key?: string;
  title: string;
  description?: string;
  tags: Array<string>;
  subs?: Array<any>;
}
