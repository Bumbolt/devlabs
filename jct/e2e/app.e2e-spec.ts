import { JctPage } from './app.po';

describe('jct App', () => {
  let page: JctPage;

  beforeEach(() => {
    page = new JctPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
