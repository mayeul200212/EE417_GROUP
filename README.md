# Smart DCU Data Dashboard

## Introduction

The Smart DCU Data Dashboard is a web application designed to visualize and summarize various types of data for decision-making within a campus environment. Utilizing sensor data like air quality, noise levels, room and campus occupancy, and parking availability, the application provides valuable insights for university management and students.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Production](#Production)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)

## Installation

To install and run the Smart DCU Data Dashboard in your local development environment, you need to have Docker, Docker-Compose, and Make installed on your machine.

1. Clone the repository:

   ```bash
   git clone https://github.com/mayeul200212/EE417_GROUP.git
   ```

2. Navigate to the cloned directory:
   ```bash
   cd EE417_GROUP
   ```

## Usage

### Development Environment

To run the project in a development environment:

```bash
make dev-all
```

### Production Environment

To deploy the project in a production environment:

```bash
make prod
```

## Features

- **Data Visualization:** Utilizes libraries like Plotly.js, Chart.js, D3.js, and Google Chart to visualize data.
- **User Authentication:** Supports multiple roles for different kinds of authenticated users.
- **Dynamic Content:** Server-side programming to display content based on context or user input.
- **Database Integration:** Back-end database connectivity for dynamic querying and updates.

## Dependencies

- Docker
- Docker-Compose
- Make

## Configuration

Before running the application, ensure Docker and Docker-Compose are properly installed and configured on your system.

## Production

You can find our site at this URL: https://www.autosup.fun

## Troubleshooting

Common issues:

- **Docker not running:** Ensure that Docker is running on your machine before executing any `make` commands.
- **Port conflicts:** Check for any port conflicts on your system that might prevent the application from starting correctly.

## Contributors

- Sonu Anthony
- Marouane Ben Zineb
- Mayeul Kergall
- Naiyuan Qing
- Basil Saji
- Shashank Haish Shrivastav
- Nishad Pramod Tapse
