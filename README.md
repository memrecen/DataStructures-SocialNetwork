Social Network Simulation (Data Structures Project)

-------------------------------------------------------------------------------------

This project is a Java-based social network backend simulation developed to demonstrate the practical application of fundamental data structures. It manages user relationships, post feeds, and activity tracking using performance-optimized data organizations.

-------------------------------------------------------------------------------------

🚀 Features
* User Management: Secure user registration, login, and account deletion.

* Friendship System: Establish or remove friendships and manage incoming friend requests.

* Mutual Friend Discovery: Find common friends between you and another user.

* Smart Friend Recommendations: An algorithm that suggests potential friends based on having at least two mutual connections.

* Post Management: Create personal posts, view a feed of friends' posts, and delete existing posts.

* Activity Feed: A chronological log of all user actions (searches, logins, posts, etc.).

* User Search: Ability to look up other users by their unique ID or Name.

-------------------------------------------------------------------------------------

🛠 Data Structures Implemented
The core of this project relies on specific data structures to ensure efficiency and academic compliance:

* Graph (Adjacency List): Friendships are represented using a Map<Users, ArrayList<Users>>, allowing for complex relationship mapping.

* Hashtable / HashMap: Used for $O(1)$ time complexity lookups of user data and counting mutual connections.

* Priority Queue: Manages user activities, ensuring they are stored and retrieved based on timestamps.

* Stack: Implemented to display the Activity Feed in a "Last-In, First-Out" (LIFO) manner, showing the most recent actions first.

* LinkedList: Used to store and manage a dynamic list of posts within the network.

* ArrayList: Utilized for dynamic lists such as friend requests and search results.

-------------------------------------------------------------------------------------

📂 Project Structure
* Model/: Contains the data models: Users, Post, and Activity.

* Controller/: Contains UsersController, the heart of the application that manages data structure operations.

* View/: Contains the console-based UI pages (e.g., MainPage, FriendsPage, LoginPage).

-------------------------------------------------------------------------------------

💻 How to Run

1. Clone the repository: git clone [repository-url]

2. Open the project in any Java IDE (NetBeans, IntelliJ, Eclipse).

3. Run Main.java to start the application.

-------------------------------------------------------------------------------------

Developed by Muhammed Emre Cengiz (mec)
