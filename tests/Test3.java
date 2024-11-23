// test/player.test.js
const Player = require('../src/player');

describe('Player Class', () => {
// Test Player Creation
describe('Player Creation', () => {
test('creates player with valid attributes', () => {
        const player = new Player(50, 5, 10);
expect(player.health).toBe(50);
expect(player.strength).toBe(5);
expect(player.attack).toBe(10);
        });

test('throws error for zero health', () => {
expect(() => new Player(0, 5, 10)).toThrow('Invalid player attributes');
        });

test('throws error for zero strength', () => {
expect(() => new Player(50, 0, 10)).toThrow('Invalid player attributes');
        });

test('throws error for zero attack', () => {
expect(() => new Player(50, 5, 0)).toThrow('Invalid player attributes');
        });
                });

// Test Health Reduction
describe('Health Reduction', () => {
test('reduces health correctly', () => {
        const player = new Player(50, 5, 10);
            player.reduceHealth(20);
expect(player.health).toBe(30);
        });

test('does not allow negative health', () => {
        const player = new Player(50, 5, 10);
            player.reduceHealth(60);
expect(player.health).toBe(0);
        });
                });

// Test Player Alive Status
describe('Player Status', () => {
test('is alive when health > 0', () => {
        const player = new Player(50, 5, 10);
expect(player.isAlive()).toBe(true);
        });

test('is not alive when health reaches 0', () => {
        const player = new Player(50, 5, 10);
            player.reduceHealth(50);
expect(player.isAlive()).toBe(false);
        });
                });
                });