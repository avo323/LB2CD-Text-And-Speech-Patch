;;; Sierra Script 1.0 - (do not remove this comment)
(script# 565)
(include sci.sh)
(use Main)
(use LbDoor)
(use LBRoom)
(use Inset)
(use Scaler)
(use PolyPath)
(use CueObj)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm565 0
)

(local
	local0
	local1
	theGLb2DoVerbCode
	theGOldCast
)
(instance rm565 of LBRoom
	(properties
		north 666
		west 550
	)
	
	(method (init)
		(gEgo
			init:
			normalize: 831
			ignoreActors:
			setScale: Scaler 130 0 190 0
		)
		(proc958_0 128 560 561 562 563 564 565 831)
		(proc958_0 132 2 6 721)
		(proc958_0 129 465 565)
		(self setRegions: 90)
		(switch gGNumber
			(north
				(global2 setScript: sEnterTunnel)
			)
			(west (gEgo x: 8 y: 150))
		)
		(super init:)
		(if (proc0_2 66)
			(global2 setScript: sDeadWatney)
		else
			(global2 picture: 560 drawPic: 560)
			(deskClock addToPic:)
			(deadWatney addToPic:)
			(calendar addToPic:)
			(intercom addToPic:)
			(phoneList addToPic:)
			(phone addToPic:)
			(safePic init: stopUpd:)
			(xWestDoor init:)
			(if (== gGNumber north)
				(Palette palSET_INTENSITY 0 255 100)
				(self setScript: sEnterTunnel)
			else
				(secretDoor init: stopUpd:)
				(self setScript: sEgoEnter)
			)
		)
	)
	
	(method (dispose)
		(DisposeScript 2565)
		(super dispose: &rest)
	)
)

(instance deskClock of View
	(properties
		x 128
		y 114
		noun 41
		approachX 89
		approachY 185
		view 563
		loop 4
		cel 5
		priority 11
		signal $4010
	)
)

(instance deadWatney of View
	(properties
		x 137
		y 114
		view 560
		priority 11
		signal $4010
	)
)

(instance calendar of View
	(properties
		x 120
		y 118
		noun 44
		approachX 99
		approachY 178
		view 563
		loop 4
		cel 1
		priority 12
		signal $4010
	)
)

(instance intercom of View
	(properties
		x 132
		y 122
		noun 42
		approachX 93
		approachY 171
		view 563
		loop 4
		cel 3
		priority 12
		signal $4010
	)
)

(instance phoneList of View
	(properties
		x 109
		y 123
		noun 43
		view 563
		loop 4
		priority 12
		signal $4010
	)
)

(instance phone of View
	(properties
		x 83
		y 118
		noun 58
		view 563
		loop 4
		cel 6
		priority 12
		signal $4010
	)
)

(instance safePic of View
	(properties
		x 82
		y 100
		noun 77
		approachX 93
		approachY 149
		view 564
		loop 1
		priority 6
		signal $4010
	)
)

(instance secretDoor of Prop
	(properties
		x 294
		y 147
		view 560
		loop 2
		cycleSpeed 12
	)
)

(instance bloodDrip of Prop
	(properties
		x 152
		y 125
		noun 78
		modNum 560
		view 565
	)
)

(instance feCpBlood of Feature
	(properties
		y 1
		noun 61
		modNum 560
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(8
				(global2 setInset: inFeCpBlood)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance feQuills of Feature
	(properties
		y 1
		noun 62
		modNum 560
		sightAngle 40
	)
)

(instance fePorcupine of Feature
	(properties
		y 1
		noun 63
		modNum 560
		sightAngle 40
	)
)

(instance feHead of Feature
	(properties
		y 1
		noun 64
		modNum 560
		sightAngle 40
	)
)

(instance feHandLeft of Feature
	(properties
		y 1
		noun 65
		modNum 560
		sightAngle 40
	)
)

(instance feHandRight of Feature
	(properties
		y 1
		noun 66
		modNum 560
		sightAngle 40
	)
)

(instance feIntercom of Feature
	(properties
		y 1
		noun 67
		modNum 560
		sightAngle 40
	)
)

(instance feClockBroken of Feature
	(properties
		y 1
		noun 53
		modNum 560
		sightAngle 40
		onMeCheck $0080
	)
)

(instance feCalendar of Feature
	(properties
		y 1
		noun 51
		modNum 560
		sightAngle 40
	)
)

(instance feBody of Feature
	(properties
		y 1
		noun 70
		modNum 560
		sightAngle 40
	)
)

(instance feDrawerBig of Feature
	(properties
		y 1
		noun 71
		modNum 560
		sightAngle 40
	)
)

(instance feDrawerTop of Feature
	(properties
		y 1
		noun 72
		modNum 560
		sightAngle 40
	)
)

(instance feDesk of Feature
	(properties
		y 1
		noun 73
		modNum 560
		sightAngle 40
	)
)

(instance sEgoEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 20 170 self)
			)
			(2
				(xWestDoor close:)
				(= ticks 60)
			)
			(3
				(proc0_5 gEgo deadWatney)
				(global2 setScript: sDeadWatney)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(secretDoor init:)
				(= cycles 2)
			)
			(1 (= seconds 3))
			(2
				(gEgo x: 306 y: 147 setPri: 5 setHeading: 180)
				(sFX number: 721 flags: 1 setLoop: 1 play:)
				(secretDoor init: setCycle: End self)
			)
			(3
				(sFX stop:)
				(gEgo setPri: -1 setMotion: MoveTo 303 177 self)
			)
			(4
				(gEgo setMotion: PolyPath 265 180 self)
				(sFX number: 721 flags: 1 setLoop: 1 play:)
				(secretDoor setCycle: Beg self)
			)
			(5 0)
			(6
				(gEgo setCycle: StopWalk -1)
				(proc0_5 gEgo deadWatney)
				(= seconds 2)
			)
			(7
				(secretDoor stopUpd:)
				(sFX stop:)
				(global2 setScript: sDeadWatney)
				(self dispose:)
			)
		)
	)
)

(instance sDeadWatney of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOldCast eachElementDo: #hide)
				(gGame setCursor: 1 1)
				(if (proc0_2 66)
					(gGameMusic2 pause: 1)
					(= local0 1)
					(fooSound number: 6 loop: -1 flags: 1 play:)
					(= cycles 1)
				else
					(proc0_3 66)
					(global2 picture: 465 drawPic: 465)
					(sFX number: 84 flags: 1 loop: 1 play:)
					(wrapMusic init: -1 2 6)
					(= local1 1)
					(= ticks 180)
				)
			)
			(1
				(gOldATPs
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
				(gGame handsOn:)
				(self setScript: sCUDeadWatney self)
			)
			(2
				(fooSound fade: 0 12 30 1)
				(if local1 (wrapMusic dispose: 1))
				(if local0 (gGameMusic2 pause: 0))
				(proc0_8 0)
				(global2 newRoom: 560)
			)
		)
	)
)

(instance sCUDeadWatney of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= theGOldCast gOldCast)
				(gOldCast eachElementDo: #dispose eachElementDo: #delete)
				(theGOldCast eachElementDo: #hide)
				(global2 picture: 565)
				(DrawPic 565)
				(Animate (theGOldCast elements?) 0)
				(global2 modNum: 560)
				(= theGLb2DoVerbCode gLb2DoVerbCode)
				(= gLb2DoVerbCode exitDoVerbCode)
				(proc0_8 1)
				(gLb2WH addToFront: self)
				(gIconBar disable: 7)
				(bloodDrip init: cycleSpeed: 12 setCycle: Fwd)
				(feCpBlood init: setOnMeCheck: 1 16384)
				(feQuills init: setOnMeCheck: 1 8192)
				(fePorcupine init: setOnMeCheck: 1 4096)
				(feHead init: setOnMeCheck: 1 2048)
				(feHandLeft init: setOnMeCheck: 1 1024)
				(feHandRight init: setOnMeCheck: 1 512)
				(feIntercom init: setOnMeCheck: 1 256)
				(feClockBroken init: setOnMeCheck: 1 128)
				(feCalendar init: setOnMeCheck: 1 64)
				(feBody init: setOnMeCheck: 1 32)
				(feDrawerBig init: setOnMeCheck: 1 16)
				(feDrawerTop init: setOnMeCheck: 1 8)
				(feDesk init: setOnMeCheck: 1 4)
			)
			(1
				(if (global2 inset:) ((global2 inset:) dispose: 0))
				(gOldCast eachElementDo: #dispose)
				(= gOldCast theGOldCast)
				(gLb2WH delete: self)
				(gIconBar enable: 7)
				(= gLb2DoVerbCode theGLb2DoVerbCode)
				(self dispose:)
			)
		)
	)
)

(instance inFeCpBlood of Inset
	(properties
		view 563
		cel 2
		x 89
		y 85
		disposeNotOnMe 1
		modNum 560
		noun 74
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sCUDeadWatney cue:))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)
	
	(method (init)
		(= wrapSound fooSound)
		(super init: &rest)
	)
)

(instance fooSound of Sound
	(properties)
)

(instance sFX of Sound
	(properties
		flags $0001
	)
)

(instance exitDoVerbCode of Code
	(properties)
	
	(method (doit param1 param2)
		(if (== param1 13)
			(sCUDeadWatney cue:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance xWestDoor of LbDoor
	(properties
		x 17
		y 148
		noun 36
		sightAngle 40
		approachX 14
		approachY 160
		view 560
		loop 1
		priority 7
		signal $0010
		entranceTo 550
		forceClose 0
		moveToX 4
		moveToY 145
	)
)
