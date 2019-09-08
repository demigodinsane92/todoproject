# TODO app project
---
## Overview
- Make a simple TODO app, which sends push notifications/alarms based on the events.
---
## Components
1. UI - Basic UI which shows the list of events in the next 24 hours.
2. Event synchroniser - Backend process which syncs events from calendar.
3. Notification generation - Backend process which generates push notifications every 30 minutes.
4. Data storage - In memory data storage on device of all events.
---
## Component design
1. UI - TODO
2. Event synchroniser - (Get only events with TODO as the prefix of the event title)
  > - Make calls to Google, Outlook calendar APIs to get list of events in the next 24 hours every 30 minutes.
  > - Also make calls to get updated event list every 24 hours for the next 2 weeks.
3. Notification generation
> - Push notifications for each event 15 minutes(configurable) before.
> - Opt in for alarm to generation for each event.
> - Check for events every five minutes.
4. Data storage
> - Simple in memory data store should suffice for the initial draft, make provision to be moved to document based data store.
