;;; Sierra Script 1.0 - (do not remove this comment)
(script# 510)
(include sci.sh)
(use Main)
(use LbDoor)
(use LBRoom)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use StopWalk)
(use Timer)
(use Sound)
(use Cycle)
(use InvI)
(use View)
(use Obj)

(public
	rm510 0
	eastDoor 2
)

(local
	local0
	local1
)
(instance rm510 of LBRoom
	(properties
		noun 10
		picture 510
		north 530
		east 550
		south 520
		west 500
		vanishingX 0
	)
	
	(method (init)
		(proc958_0 128 510 511 831)
		(if (and (== global123 4) (== global111 11))
			(proc958_0 128 820 812 817)
			(Load rsSOUND 332)
		)
		(proc958_0 132 531 721)
		(gEgo init: normalize: 831 setScale: Scaler 120 0 190 0)
		(self setRegions: 90)
		(switch gGNumber
			(521
				(gGame handsOff:)
				(gEgo posn: 86 175)
				(WrapMusic pause: 0)
				(self setScript: sOlympiaEnters)
			)
			(north
				(gEgo x: 278 y: 147)
				(self setScript: sEnterNorth)
			)
			(east
				(gEgo edgeHit: 0 setHeading: 180)
				(if (and (== global123 4) (== global111 11))
					(WrapMusic pause: 1)
					(gGameMusic2 number: 332 loop: -1 flags: 1 play:)
					(olympia
						init:
						setCycle: StopWalk -1
						setScale: Scaler 140 20 190 0
					)
					(steve
						init:
						setCycle: StopWalk -1
						setScale: Scaler 140 20 190 0
					)
				else
					(WrapMusic pause: 0)
				)
				(self cue:)
			)
			(west
				(self setScript: sEnterWest)
			)
			(26
				(WrapMusic init: 1 90 91 92 93)
				(= global111 11)
				(self setScript: sEnterWest)
			)
			(south
				(self cue:)
				(WrapMusic pause: 0)
				(if (== ((Inv at: 14) owner?) 0)
					(self setScript: sFollowOlympia)
					((Inv at: 14) owner: 630)
				)
			)
			(else 
				(gEgo posn: 86 175)
				(WrapMusic pause: 0)
				(self cue:)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (proc0_2 31)
			(rodinDudeHead
				init:
				cel: (rodinDudeHead lastCel:)
				stopUpd:
			)
		else
			(rodinDudeHead init: stopUpd:)
		)
		(eastDoor init:)
		(statue1 init: setOnMeCheck: 1 32)
		(statue2 init: setOnMeCheck: 1 64)
		(statue3 init: setOnMeCheck: 1 128)
		(statue4 init: setOnMeCheck: 1 256)
		(arch init: setOnMeCheck: 1 16)
		(rodinSeam init: setOnMeCheck: 1 4096)
		(rodinBody init: setOnMeCheck: 1 16384)
		(transom init: setOnMeCheck: 1 512)
		(wall init: setOnMeCheck: 1 1024)
		(southExitFeature init:)
		(if (proc999_5 global111 0 6 10 14)
			(eastDoor locked: 1)
		)
		(if
			(and
				(== global123 4)
				(not (== gGNumber 521))
				(not (proc0_2 62))
				(proc0_10 16648 1)
				(not (proc0_2 92))
			)
			(proc0_3 62)
			(self setScript: sMeanwhile)
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_1 gEgo 2) (self setScript: sExitWest))
			((proc0_1 gEgo 4) (self setScript: sExitNorth))
			((proc0_1 gEgo 2048) (global2 setScript: sExitSouth))
		)
	)
	
	(method (cue)
		(cond 
			((== global111 0)
				(if (== ((ScriptID 90 2) room?) gNumber)
					(gGame handsOff:)
					((ScriptID 90 2) goTo: 550 self)
				else
					((ScriptID 90 2) moveTo: -2)
					(waterPrompt setReal: waterPrompt 5)
				)
			)
			((proc999_5 global111 4 10 12) (waterPrompt setReal: waterPrompt 5))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (gTimers contains: waterPrompt)
			(waterPrompt dispose: delete:)
		)
		(cond 
			((proc999_5 newRoomNumber 500 530)
				(switch global111
					(3 (++ global111))
					(5
						(= global111 (+ global111 2))
					)
					(6 (++ global111))
					(13 (++ global111))
				)
			)
			((== newRoomNumber 520) (WrapMusic pause: 1))
		)
		(if (proc999_5 global111 1 11 15)
			((ScriptID 90 6) moveTo: -2)
		)
		(if
			(and
				(== global111 7)
				(== ((ScriptID 90 6) room?) -2)
				(not (proc0_10 -15612))
			)
			((ScriptID 90 6) moveTo: 510 goTo: 430)
		)
		(if local1 (proc0_4 31))
		(if (!= newRoomNumber east) (proc0_4 97))
		(super newRoom: newRoomNumber)
	)
)

(instance olympia of Actor
	(properties
		x 256
		y 184
		view 820
		cel 5
		priority 13
		signal $4010
	)
)

(instance steve of Actor
	(properties
		x 285
		y 184
		view 812
		loop 1
		cel 4
		priority 13
		signal $0010
	)
)

(instance yvette of Actor
	(properties
		x 309
		y 159
		view 817
		loop 1
		priority 13
		signal $0010
	)
)

(instance rodinDudeHead of Prop
	(properties
		x 166
		y 127
		noun 6
		view 511
		loop 1
		priority 14
		signal $0010
		cycleSpeed 12
	)
	
	(method (init)
		(super init:)
		(self stopUpd:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (proc0_2 31)
					(proc0_4 31)
				else
					(gGame points: 1 142)
					(proc0_3 31)
				)
				(rodinDudeHead setScript: sRodinFlipSwitch)
			)
			(8 (gLb2Messager say: 7 1))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance eastDoor of LbDoor
	(properties
		x 319
		y 95
		noun 2
		modNum 1510
		sightAngle 40
		approachX 309
		approachY 163
		view 510
		priority 8
		signal $0010
		entranceTo 550
		listenVerb 38
		moveToX 310
		moveToY 157
		enterType 0
		exitType 0
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 4 38)
	)
	
	(method (cue)
		(super cue:)
		(if (== doorState 0)
			(if (and (== global123 4) (== global111 11))
				(self setScript: sSteveYvetteMeeting)
			)
			(if
				(and
					(== global123 4)
					(not (== gGNumber 521))
					(not (proc0_2 62))
					(proc0_10 16648 1)
					(not (proc0_2 92))
				)
				(proc0_3 62)
				(global2 newRoom: 521)
			)
		)
	)
	
	(method (listen)
		(if (gTimers contains: waterPrompt)
			(waterPrompt dispose: delete:)
		)
		(switch global111
			(0
				(gLb2Messager say: 2 38 2 0 0 1510)
				(++ global111)
			)
			(4
				(gLb2Messager say: 2 38 5 0 0 1510)
				(++ global111)
			)
			(10
				(gLb2Messager say: 2 38 6 0 0 1510)
				(++ global111)
			)
			(12
				(global2 setScript: sListenToYvetteAndSteve)
				(++ global111)
			)
			(else  (super listen:))
		)
	)
	
	(method (createPoly)
		(super createPoly: 297 152 319 156 319 164 297 160)
	)
)

(instance statue1 of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gLb2Messager say: 14 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance statue2 of Feature
	(properties
		x 100
		y 1
		noun 2
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gLb2Messager say: 14 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance statue3 of Feature
	(properties
		x 200
		y 1
		noun 3
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gLb2Messager say: 14 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance statue4 of Feature
	(properties
		x 300
		y 1
		noun 4
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gLb2Messager say: 14 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance arch of Feature
	(properties
		y 1
		noun 5
	)
)

(instance rodinSeam of Feature
	(properties
		x 160
		y 161
		noun 7
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (proc0_2 31)
					(proc0_4 31)
				else
					(gGame points: 1 142)
					(proc0_3 31)
				)
				(rodinDudeHead setScript: sRodinFlipSwitch)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rodinBody of Feature
	(properties
		x 160
		y 159
		noun 8
		sightAngle 40
	)
)

(instance transom of Feature
	(properties
		x 360
		y 84
		noun 9
		sightAngle 40
	)
)

(instance wall of Feature
	(properties
		y 1
		noun 11
	)
)

(instance sExitSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 setMotion: MoveFwd 80 self)
			)
			(1
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance sExitWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 setMotion: MoveFwd 20 self)
			)
			(1
				(global2 newRoom: (global2 west?))
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 18 150
					setHeading: 90
					setMotion: MoveFwd 30 self
				)
			)
			(1
				(global2 cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveFwd 25 self)
			)
			(1
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 225 setMotion: PolyPath 247 155 self)
			)
			(1
				(global2 cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

;;;(instance sExitEast of Script
;;;	(properties)
;;;	
;;;	(method (changeState newState)
;;;		(switch (= state newState)
;;;			(0
;;;				(gGame handsOff:)
;;;				(gEgo setHeading: 45 setMotion: MoveFwd 20 self)
;;;			)
;;;			(1
;;;				(global2 newRoom: (global2 east?))
;;;			)
;;;		)
;;;	)
;;;)
;;;
(instance sRodinFlipSwitch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 186 185 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(gEgo
					view: 511
					setLoop: 0
					cel: 0
					posn: 174 184
					cycleSpeed: 12
					setScale: Scaler 100 100 190 0
					setCycle: End self
				)
			)
			(3
				(sFX number: 531 flags: 1 play:)
				(if (proc0_2 31)
					(rodinDudeHead setCycle: End self)
				else
					(rodinDudeHead setCycle: Beg self)
				)
				(gEgo
					normalize: 831
					loop: 1
					posn: 186 185
					setScale: Scaler 120 0 190 0
				)
			)
			(4
				(rodinDudeHead stopUpd:)
				(sFX number: 721 flags: 1 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSteveYvetteMeeting of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gEgo setMotion: PolyPath 273 172 self)
			)
			(2 (= ticks 60))
			(3
				(proc0_5 gEgo steve)
				(= ticks 60)
			)
			(4
				(gLb2Messager say: 1 0 1 1 self 1510)
			)
			(5
				(proc0_5 steve gEgo)
				(= ticks 60)
			)
			(6
				(gLb2Messager say: 1 0 1 2 self 1510)
			)
			(7
				(proc0_5 olympia gEgo)
				(= ticks 60)
			)
			(8
				(proc0_5 olympia steve)
				(= ticks 60)
			)
			(9
				(gLb2Messager say: 1 0 1 3 self 1510)
			)
			(10 (= ticks 60))
			(11
				(olympia
					setCycle: Walk
					setMotion: PolyPath (olympia x?) 250 self
				)
			)
			(12
				(olympia dispose:)
				(gEgo setMotion: PolyPath 256 184 self)
			)
			(13
				(proc0_5 gEgo steve)
				(proc0_5 steve gEgo)
				(= ticks 60)
			)
			(14
				(gLb2Messager say: 1 0 3 0 0 1510)
				(= ticks 60)
			)
			(15 (= ticks 60))
			(16
				(eastDoor setCycle: End self)
				(doorSound number: 46 play:)
				(gNewList delete: (eastDoor doorPoly?))
			)
			(17 (= ticks 60))
			(18
				(proc0_5 yvette steve)
				(= ticks 60)
			)
			(19
				(yvette
					init:
					setScale: Scaler 140 20 190 0
					setCycle: Walk
					setMotion: MoveTo 298 174 self
				)
			)
			(20
				(yvette setCycle: StopWalk -1)
				(= cycles 1)
			)
			(21
				(proc0_5 yvette steve)
				(= cycles 10)
			)
			(22
				(proc0_5 yvette gEgo)
				(= cycles 10)
			)
			(23
				(proc0_5 yvette steve)
				(= cycles 10)
			)
			(24
				(gLb2Messager say: 1 0 1 17 self 1510)
			)
			(25 (proc0_5 steve yvette self))
			(26 (= cycles 1))
			(27
				(gLb2Messager say: 1 0 1 18 self 1510)
			)
			(28
				(gLb2Messager say: 1 0 1 19 self 1510)
			)
			(29
				(yvette setCycle: Walk setMotion: MoveTo 309 159 self)
			)
			(30
				(yvette hide: dispose:)
				(= cycles 1)
			)
			(31
				(proc0_5 steve eastDoor)
				(proc0_5 gEgo eastDoor)
				(= ticks 60)
			)
			(32
				(proc0_5 steve gEgo)
				(proc0_5 gEgo steve)
				(= ticks 60)
			)
			(33
				(gLb2Messager say: 1 0 1 20 self 1510)
			)
			(34
				(gLb2Messager say: 1 0 1 21 self 1510)
			)
			(35
				(gLb2Messager say: 1 0 1 22 self 1510)
			)
			(36
				(steve setMotion: MoveTo 309 159 self)
			)
			(37
				(proc0_5 gEgo eastDoor)
				(steve hide:)
				(= cycles 1)
			)
			(38
				(eastDoor setCycle: Beg self)
				(doorSound number: 47 play:)
				(gNewList add: (eastDoor doorPoly?))
				(= ticks 60)
			)
			(39
				(gGameMusic2 fade: 0 12 5 1)
				(= cycles 1)
			)
			(40
				(gLb2Messager say: 1 0 1 23 self 1510)
			)
			(41
				(gLb2Messager say: 1 0 1 24 self 1510)
			)
			(42
				((ScriptID 22 0) doit: 8961 self)
			)
			(43
				(++ global111)
				(waterPrompt setReal: waterPrompt 3)
				(WrapMusic pause: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 15))
			(1
				(olympia
					posn: 100 210
					setCycle: Walk
					setScale: Scaler 140 20 190 0
					setPri: -1
					setMotion: PolyPath (- (gEgo x?) 20) (gEgo y?) self
					init:
				)
				(= seconds 2)
			)
			(2 (proc0_5 gEgo olympia))
			(3 (proc0_5 gEgo olympia self))
			(4 (proc0_5 olympia gEgo self))
			(5 (= cycles 1))
			(6
				(olympia setCycle: StopWalk -1)
				(= cycles 1)
			)
			(7 (= cycles 1))
			(8
				(gLb2Messager say: 1 0 24 0 self 1892)
			)
			(9
				(olympia setMotion: PolyPath 13 146 self)
			)
			(10
				(gGame handsOn:)
				(olympia dispose:)
				(proc0_4 62)
				(self dispose:)
			)
		)
	)
)

(instance sFollowOlympia of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3 31)
				(= local1 1)
				(gEgo posn: (gEgo x?) (+ (gEgo y?) 20))
				(rodinDudeHead cel: (rodinDudeHead lastCel:))
				(olympia
					posn: 196 161
					setScale: Scaler 140 20 190 0
					init:
				)
				(= cycles 15)
			)
			(1
				(olympia
					setPri: -1
					setCycle: StopWalk -1
					setMotion: PolyPath 271 142 self
				)
			)
			(2
				(olympia dispose:)
				(gEgo init: setMotion: PolyPath 86 175 self)
			)
			(3
				(sFX number: 721 flags: 1 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags $0001
	)
)

(instance doorSound of Sound
	(properties
		flags $0001
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 15
	)
)

(instance sMeanwhile of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch gGNumber
					((global2 north?)
						(gEgo x: 278 y: 147)
						(self setScript: sEnterNorth self)
					)
					((global2 west?)
						(self setScript: sEnterWest self)
					)
					(else  (= cycles 1))
				)
			)
			(1 (global2 newRoom: 521))
		)
	)
)

(instance sListenToYvetteAndSteve of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLb2Messager say: 2 38 4 0 self 1510)
			)
			(1
				(proc0_3 75)
				(eastDoor doVerb: 4)
			)
		)
	)
)

(instance waterPrompt of Timer
	(properties)
	
	(method (cue)
		(gLb2Messager say: 16)
	)
)
